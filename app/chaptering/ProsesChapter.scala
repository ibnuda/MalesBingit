package chaptering

/**
 * Created by Ikrur on 21/09/2015.
 */

import net.ruippeixotog.scalascraper.browser.Browser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
import org.jsoup.nodes.{Element, Document}
import org.jsoup.select.Elements

import scala.collection.mutable

class ProsesChapter {

  def scrapPage(url: String): Document = {
    val browser = new Browser
    val document = browser.get(url)
    println("selesai scrapping page")
    document
  }

  def extractLinks(document: Document, elemen: String): List[String] = {
    val elem: Elements = document.getElementsByClass(elemen).select("a[href]")
    val links: mutable.Buffer[Element] = for (
      el <- elem
    ) yield(el)
    val linksAkhir: List[String] = links.toList.map(_.attr("href"))
    linksAkhir.foreach(println(_))
    linksAkhir
  }

  def extractChapter(url: String, elemen: String): String = {
    val document = scrapPage(url)
    println("scrapping chapter.")
    //val kontenChapter: String = document >> extractor(elemen, text)
    val kontenChapter = document.getElementsByClass(elemen).text
    println(kontenChapter)
    kontenChapter
  }

  def downloadAllChapters(url: String, elemen: String): List[String] = {
    println(url)
    println(elemen)
    val documentChapterList: Document = scrapPage(url)
    val chapterLists: List[String] = extractLinks(documentChapterList, elemen)
    println("selesai extract links")
    val chapterContents: List[String] = chapterLists.map(x => extractChapter(x, elemen))

    chapterContents
  }
}
