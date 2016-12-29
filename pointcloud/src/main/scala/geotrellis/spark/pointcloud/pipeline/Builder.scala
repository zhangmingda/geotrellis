package geotrellis.spark.pointcloud.pipeline

import geotrellis.spark.pointcloud.pipeline._
import geotrellis.spark.pointcloud.pipeline.json._

import io.circe.syntax._

class Builder {
  val obj = Read("path", Some("crs")) ~ ReprojectionFilter("crsreproject") ~ ReprojectionFilter("") ~ Write("")

  obj.mapExpr {
    case read: Read => read.copy(filename = "path2")
    case s => s
  }

  val json = obj.asJson
}
