resource "aws_s3_bucket" "transportes_mj_s3" {
  bucket = "transportes-mj-s3"
  depends_on = [
    aws_db_instance.transportes_mj_rds
  ]
  force_destroy = true
  tags = {
    Name = "Transportes MJ S3"
  }
}

resource "aws_s3_bucket_acl" "github_actions_acl" {
  bucket = aws_s3_bucket.transportes_mj_s3.id
  acl    = "private"
}
