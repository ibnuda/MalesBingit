package controllers

import models.Tautan.Tautan
import play.api._
import play.api.mvc._

import chaptering.ProsesChapter

import forms.FormUrl
import forms.Wat

object Application extends Controller {

  def index = Action {
    Ok(views.html.index(FormUrl.form))
  }

  def prosesChapter() = Action { implicit request =>
    val tautan: Tautan = FormUrl.form.bindFromRequest.get
    val prosChap = new ProsesChapter
    Ok(views.html.chapter(prosChap.downloadAllChapters(tautan.link, tautan.kelas)))
  }

}