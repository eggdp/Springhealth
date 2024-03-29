package com.example.hello;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupComponentLocalMain {

    public static void getStockPriceList() {

        final String stockList = "https://finance.naver.com/sise/sise_market_sum.nhn?&page=1";
        Connection conn = Jsoup.connect(stockList);

        try {
            Document document = conn.get();
            String thead = getStockHeader(document); // 칼럼명
            String tbody = getStockList(document);   // 데이터 리스트
            System.out.println(thead);
            System.out.println(tbody);

        } catch (IOException ignored) {
        }
    }

    public static String getStockHeader(Document document) {
        Elements stockTableBody = document.select("table.type_2 thead tr");
        StringBuilder sb = new StringBuilder();
        for (Element element : stockTableBody) {
            for (Element td : element.select("th")) {
                sb.append(td.text());
                sb.append("   ");
            }
            break;
        }
        return sb.toString();
    }

    public static String getStockList(Document document) {
        Elements stockTableBody = document.select("table.type_2 tbody tr");
        StringBuilder sb = new StringBuilder();
        for (Element element : stockTableBody) {
            if (element.attr("onmouseover").isEmpty()) {
                continue;
            }

            for (Element td : element.select("td")) {
                String text;
                if(td.select(".center a").attr("href").isEmpty()){
                    text = td.text();
                }else{
                    text = "https://finance.naver.com"+td.select(".center a").attr("href");
                }
                sb.append(text);
                sb.append("   ");
            }
//            sb.append(System.getProperty("line.separator")); //줄바꿈
        }
        return sb.toString();
    }

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    public static void getMelonMusicList() {

        final String stockList = "https://www.melon.com/chart/index.htm";
        Connection conn = Jsoup.connect(stockList);

        try {
            Document document = conn.get();
//            String thead = getStockHeader(document); // 칼럼명
            String tbody = getMusicList(document);   // 데이터 리스트
//            System.out.println(thead);
//            System.out.println(tbody);

        } catch (IOException ignored) {
        }
    }

    public static String getMusicList(Document document) {
        Elements stockTableBody = document.select("div.wrap_song_info");
        StringBuilder sb = new StringBuilder();
        int rank = 1;
        for (Element element : stockTableBody.select("div.ellipsis.rank01")) {
            String song = element.select("a").text();   // 노래 제목
            System.out.println((rank++) + ": " + song);
        }
        rank = 1;
        for (Element element : stockTableBody.select("span.checkEllipsis")) {
            String song = element.select("a").text();   // 노래 제목
            System.out.println((rank++) + ": " + song);
        }
//        for (Element element : stockTableBody) {
//            for (Element td : element.select("div.ellipsis.rank01")) {
//                String song = td.select("a").text();   // 노래 제목
//
//                System.out.println((rank++) + ": " + song);
////                if (!text.isEmpty()) {
////                    System.out.println("순위: " + rank++);
////                    System.out.println("제목: " + text);
//////                    sb.append("제목: " + text);
////                }
////                sb.append("   ");
////                text = td.select("span.checkEllipsis a").text();   // 가수
////                if (!text.isEmpty()) {
////                    System.out.println("가수: " + text);
//////                    sb.append("가수: " + text);
////                }
//            }
////            sb.append(System.getProperty("line.separator")); //줄바꿈
//        }
        return sb.toString();
    }

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    public static void getMovieRankList() {

        final String stockList = "https://movie.naver.com/movie/sdb/rank/rmovie.naver";
        Connection conn = Jsoup.connect(stockList);

        try {
            Document document = conn.get();
            //  String thead = getStockHeader(document); // 칼럼명
            String tbody = getMovieList(document);   // 데이터 리스트
            //   System.out.println(thead);
            System.out.println(tbody);

        } catch (IOException ignored) {
        }
    }


    public static String getMovieList(Document document) {
        Elements stockTableBody = document.select("td.title");
        StringBuilder sb = new StringBuilder();
        for (Element element : stockTableBody) {

            for (Element td : element.select("td.ac")) {
                String text;
                text= td.select("img.get(src)").text(); //순위
                if(!text.isEmpty())
                    sb.append("순위: "+text);
            }

            for (Element td : element.select("div.tit3")) {
                String text;

                text = td.select(".tit3 a").text(); //영화제목
                if (!text.isEmpty())
                    sb.append("제목: " + text);
                sb.append("  ");
            }


            sb.append(System.getProperty("line.separator")); //줄바꿈
        }
        return sb.toString();
    }

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ


    public static void getMovieRankList2() {

        final String stockList = "https://movie.naver.com/movie/running/current.naver";
        Connection conn = Jsoup.connect(stockList);

        try {
            Document document = conn.get();
            //  String thead = getStockHeader(document); // 칼럼명
            String tbody = getMovieList(document);   // 데이터 리스트
            //   System.out.println(thead);
            System.out.println(tbody);

        } catch (IOException ignored) {
        }
    }


    public static String getMovieList2(Document document) {
        Elements stockTableBody = document.select("div.lst_wrap");
        StringBuilder sb = new StringBuilder();
        for (Element element : stockTableBody) {
           for (Element td : element.select("div")) {
                String text;
                if(td.select(".lst_detail_t1").attr("div.thumb").isEmpty()){
                    text = td.text();
                    sb.append("이미지: "+text);
                    sb.append("   ");
                }
                if(td.select("dl.lst_dsc").attr("dt.tit").isEmpty()){
                    text = td.text();
                    sb.append("제목: "+text);
                    sb.append("   ");
                }else{

                }
                sb.append("   ");
            }
//            sb.append(System.getProperty("line.separator")); //줄바꿈
        }
        return sb.toString();
    }



    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    public static void main(String[] args) {
//        getStockPriceList();
//        getMelonMusicList();
  //      getMovieRankList();
        getMovieRankList2();
    }
}
