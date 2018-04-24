package com.github.yandoroshenko.scalafp.monoid

/**
  * Created by Yan Doroshenko (yandoroshenko@protonmail.com) on 24.04.2018.
  */
trait Monoid[A] {
  def id: A

  def compose(x: A, y: A): A
}
