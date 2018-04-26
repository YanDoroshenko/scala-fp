package com.github.yandoroshenko.scalafp.monoid

import org.scalacheck.Prop.forAll
import org.scalacheck.{Arbitrary, Properties}

import scala.reflect._

class IntSumMonoidSpec extends MonoidSpec(MonoidInstances.intSumMonoid)
class IntMultiplyMonoidSpec extends MonoidSpec(MonoidInstances.intMultiplyMonoid)
class IntMaxMonoidSpec extends MonoidSpec(MonoidInstances.intMaxMonoid)
class StringAlphabeticConcatenationMonoidSpec extends MonoidSpec(MonoidInstances.stringAlphabeticConcatenationMonoid)

/**
  * Created by Yan Doroshenko (yandoroshenko@protonmail.com) on 24.04.2018.
  */
abstract class MonoidSpec[A: ClassTag](monoid: Monoid[A])(implicit arbitrary: Arbitrary[A]) extends Properties(s"Monoid for ${classTag[A]}") {

  property("identity composition with identity") = forAll { _: A =>
    monoid.compose(monoid.id, monoid.id) == monoid.id
  }

  property("something composition with identity") = forAll { a: A =>
    monoid.compose(a, monoid.id) == a
  }

  property("identity composition with something") = forAll { a: A =>
    monoid.compose(monoid.id, a) == a
  }

  property("composition associativity") = forAll { (a: A, b: A) =>
    monoid.compose(a, b) == monoid.compose(b, a)
  }
}
