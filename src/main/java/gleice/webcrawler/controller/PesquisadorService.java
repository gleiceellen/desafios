/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gleice.webcrawler.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

/**
 *
 * @author gleiceellen
 */
@Service
public class PesquisadorService {
    
    private void impressao(String msg) {
        System.out.println(String.format(msg));
    }
    
    public List quebraString(String dados) throws IOException{

        int stop = dados.indexOf(";");
        int stop2 = dados.lastIndexOf(";");
        int ultimo = dados.length();

        List red = new ArrayList<>();

        red.add(dados.substring(0,stop));
        red.add(dados.substring(stop+1,stop2));
        red.add(dados.substring(stop2+1,ultimo));

        return recebeEntrada(red);
            
    }
    
    public List recebeEntrada(List melhoresReddits) throws IOException{
        
        ArrayList novo = new ArrayList<>();
        novo.add(pesquisa(melhoresReddits.get(0).toString()));
        novo.add(pesquisa(melhoresReddits.get(1).toString()));
        novo.add(pesquisa(melhoresReddits.get(2).toString()));
        
        return novo;
        
    }
    
    private ArrayList pesquisa(String r1) throws IOException{
        Document doc = Jsoup.connect("https://www.reddit.com/r/"+r1).get();
       
        Elements melhoresubreddits = doc.select("#siteTable");
        ArrayList reddits = new ArrayList<>();    
            for (Element melhorsubr : melhoresubreddits) {
                
                Elements subreddits = melhorsubr.children(); 
                for(Element subreddit : subreddits){
                    subreddit.getElementsByClass("a[class=title may-blank]");
                    Elements scoreUnvoted = subreddit.select(".score.unvoted");
                    for (Element score : scoreUnvoted) {
                        if(score.attr("title")!="" && score.attr("title")!=null){
                            if(Integer.parseInt(score.attr("title"))>5000){

                                reddits.add(subreddit.text());
                                impressao(subreddit.text());

                            }else{
                                System.out.println("Não há reddits com mais do que 5000 votos!");
                            }
                        }else{
                            System.out.println("Não há votos!");
                        }
                    }
                }
            }
        return reddits;
    }

    
    
}
