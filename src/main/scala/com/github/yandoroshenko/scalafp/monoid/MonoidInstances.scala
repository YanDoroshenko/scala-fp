package com.github.yandoroshenko.scalafp.monoid

/**
  * Created by Yan Doroshenko (yandoroshenko@protonmail.com) on 24.04.2018.
  */
object MonoidInstances {

  val intSumMonoid = new Monoid[Int] {
    override def id: Int = 0

    override def compose(x: Int, y: Int): Int = x + y
  }
}
