resource "aws_vpc" "transportes_mj_vpc" {
  cidr_block           = "10.0.0.0/16"
  enable_dns_hostnames = true
  enable_dns_support   = true

  tags = {
    "Name" = "transportes-mj"
  }
}

resource "aws_subnet" "transportes_mj_subnet" {
  vpc_id                  = aws_vpc.transportes_mj_vpc.id
  cidr_block              = "10.0.1.0/24"
  availability_zone       = "us-east-1a"
  map_public_ip_on_launch = true

  tags = {
    "Name" = "transportes-mj-subnet"
  }
}

resource "aws_subnet" "transportes_mj_db_subnet_1" {
  vpc_id                  = aws_vpc.transportes_mj_vpc.id
  cidr_block              = "10.0.2.0/24"
  availability_zone       = "us-east-1b"
  map_public_ip_on_launch = true

  tags = {
    "Name" = "transportes-mj-db-subnet-1"
  }
}

resource "aws_subnet" "transportes_mj_db_subnet_2" {
  vpc_id                  = aws_vpc.transportes_mj_vpc.id
  cidr_block              = "10.0.3.0/24"
  availability_zone       = "us-east-1c"
  map_public_ip_on_launch = true

  tags = {
    "Name" = "transportes-mj-db-subnet-2"
  }
}

resource "aws_internet_gateway" "transportes_mj_gw" {
  vpc_id = aws_vpc.transportes_mj_vpc.id

  tags = {
    "Name" = "transportes-mj-gw"
  }
}

resource "aws_route_table" "transportes_mj_rtb_pub" {
  vpc_id = aws_vpc.transportes_mj_vpc.id

  tags = {
    "Name" = "transportes-mj-rtb-pub"
  }
}

resource "aws_route" "transportes_mj_rtb" {
  route_table_id         = aws_route_table.transportes_mj_rtb_pub.id
  destination_cidr_block = "0.0.0.0/0"
  gateway_id             = aws_internet_gateway.transportes_mj_gw.id
}

resource "aws_route_table_association" "transportes_mj_rtba_pub" {
  route_table_id = aws_route_table.transportes_mj_rtb_pub.id
  subnet_id      = aws_subnet.transportes_mj_subnet.id
}
