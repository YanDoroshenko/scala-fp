package com.github.yandoroshenko.scalafp.monoid

/**
  * Created by Yan Doroshenko (yandoroshenko@protonmail.com) on 24.04.2018.
  */
object MonoidInstances {

  val intSumMonoid = new Monoid[Int] {
    override def id: Int = 0

    override def compose(x: Int, y: Int): Int = x + y
  }

  val intMultiplyMonoid = new Monoid[Int] {
    override def id: Int = 1

    override def compose(x: Int, y: Int): Int = x * y
  }

  val intMaxMonoid = new Monoid[Int] {
    override def id: Int = Int.MinValue

    override def compose(x: Int, y: Int): Int = Math.max(x, y)
  }

  val stringAlphabeticConcatenationMonoid = new Monoid[String] {
    override def id: String = ""

    override def compose(x: String, y: String): String =
      if (x < y)
        x + y
      else
        y + x
  }
}
