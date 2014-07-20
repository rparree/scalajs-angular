package com.greencatsoft.angularjs

import scala.scalajs.js

trait RouteProviderAware extends InjectionTarget {

  implicit var routeProvider: RouteProvider = _

  override def dependencies = super.dependencies :+ RouteProvider.Name

  override def inject(args: Seq[js.Any]) {
    super.inject(args)

    var index = dependencies.indexOf(RouteProvider.Name) ensuring (_ >= 0)
    this.routeProvider = args(index).asInstanceOf[RouteProvider]
  }
}