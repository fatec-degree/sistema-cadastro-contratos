resource "aws_security_group" "transportes_mj_sg" {
  name        = "transportes-mj-sg"
  description = "Transportes MJ Security Group"
  vpc_id      = aws_vpc.transportes_mj_vpc.id

  tags = {
    "Name" = "transportes-mj-sg"
  }
}

resource "aws_security_group_rule" "public_out" {
  type        = "egress"
  from_port   = 0
  to_port     = 0
  protocol    = "-1"
  cidr_blocks = ["0.0.0.0/0"]

  security_group_id = aws_security_group.transportes_mj_sg.id
}

resource "aws_security_group_rule" "public_in_http" {
  type              = "ingress"
  from_port         = 80
  to_port           = 80
  protocol          = "tcp"
  cidr_blocks       = ["0.0.0.0/0"]
  security_group_id = aws_security_group.transportes_mj_sg.id
}

resource "aws_security_group" "transportes_mj_db_sg" {
  name        = "transportes-mj-db-sg"
  description = "Transportes MJ DB Security Group"
  vpc_id      = aws_vpc.transportes_mj_vpc.id

  tags = {
    "Name" = "transportes-mj-db-sg"
  }
}

resource "aws_security_group_rule" "connect_db" {
  type              = "ingress"
  from_port         = 3306
  to_port           = 3306
  protocol          = "tcp"
  cidr_blocks       = ["0.0.0.0/0"]
  security_group_id = aws_security_group.transportes_mj_db_sg.id
}
