package io.finch

import java.util.UUID

import com.twitter.util.Try

class ExtractorSpec extends FinchSpec {

  "An extracting Endpoint (string)" should "extract one path segment" in {
    check { i: Input =>
      string(i).value === i.headOption
    }
  }

  "An extracting Endpoint (int)" should "extract one path segment" in {
    check { i: Input =>
      int(i).value === i.headOption.flatMap(s => Try(s.toInt).toOption)
    }
  }

  "An extracting Endpoint (boolean)" should "extract one path segment" in {
    check { i: Input =>
      boolean(i).value === i.headOption.flatMap(s => Try(s.toBoolean).toOption)
    }
  }

  "An extracting Endpoint (long)" should "extract one path segment" in {
    check { i: Input =>
      long(i).value === i.headOption.flatMap(s => Try(s.toLong).toOption)
    }
  }

  "An extracting Endpoint (uuid)" should "extract one path segment" in {
    check { i: Input =>
      uuid(i).value === i.headOption.flatMap(s => Try(UUID.fromString(s)).toOption)
    }
  }
}
