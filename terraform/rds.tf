resource "aws_db_instance" "transportes_mj_rds" {
  identifier                  = "transportes-mj-db"
  db_name                     = "contracts_db"
  engine                      = "mysql"
  engine_version              = "8.0.31"
  instance_class              = "db.t2.micro"
  username                    = var.DATABASE_USER
  password                    = var.DATABASE_PASS
  parameter_group_name        = "default.mysql8.0"
  skip_final_snapshot         = true
  allocated_storage           = 20
  max_allocated_storage       = 0
  apply_immediately           = true
  multi_az                    = false
  port                        = 3306
  allow_major_version_upgrade = true
  auto_minor_version_upgrade  = false
  vpc_security_group_ids      = [aws_security_group.transportes_mj_db_sg.id]
  db_subnet_group_name        = aws_db_subnet_group.transportes_mj_db_subnet_group.name
}

resource "aws_db_subnet_group" "transportes_mj_db_subnet_group" {
  name = "transportes_mj_db_subnet"
  subnet_ids = [aws_subnet.transportes_mj_db_subnet_1.id,
  aws_subnet.transportes_mj_db_subnet_2.id]

  tags = {
    Name = "Transportes MJ DB subnet group"
  }
}
