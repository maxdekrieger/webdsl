package org.webdsl.search;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collections;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharReader;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.solr.analysis.HTMLStripCharFilter;
import org.webdsl.logging.Logger;

public class ResultHighlighter {

    public static String highlight( IndexReader ir, Analyzer an, Query query,  String field, String text, String preTag, String postTag, int fragments, int fragmentLength, String separator, boolean analyzeWholeDoc, boolean stripHTML ){
//        long tmp = System.currentTimeMillis( );
        String result = "";
        TokenStream tokenStream;
        Highlighter highlighter;
        Reader reader;

        if( query != null ){
            QueryScorer qs = new QueryScorer( query, ir, field );
            qs.setExpandMultiTermQuery( true );
            highlighter = new Highlighter( new SimpleHTMLFormatter( preTag, postTag ), qs );
            highlighter.setTextFragmenter( new SimpleFragmenter( fragmentLength ) );
            if ( analyzeWholeDoc ) { highlighter.setMaxDocCharsToAnalyze( text.length( ) ); }
            reader = ( stripHTML ) ? new HTMLStripCharFilter( CharReader.get( new StringReader( text ) ), Collections.<String> emptySet( ), 65536 ) : new StringReader( text );
            tokenStream = an.tokenStream( field, reader );
            try {
                result = highlighter.getBestFragments( tokenStream, text, fragments, separator );
            } catch ( IOException e ) {
                result = "";
                Logger.error(e);
            } catch ( InvalidTokenOffsetsException e ) {
                result = "";
                Logger.error(e);
            }
        }
//        System.out.println( "highlighting took:" + ( System.currentTimeMillis( ) - tmp ) + "ms" );
        return result;

    }
}