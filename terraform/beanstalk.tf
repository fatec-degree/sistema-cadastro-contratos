resource "aws_elastic_beanstalk_application" "transportes_mj_beanstalk" {
  name        = "transportes_mj"
  description = "Transporte Escolar MJ"
  depends_on = [
    aws_s3_bucket.transportes_mj_s3
  ]
}

resource "aws_elastic_beanstalk_environment" "transportes_mj_prd" {
  name                = "transportes-mj-prd"
  application         = aws_elastic_beanstalk_application.transportes_mj_beanstalk.name
  solution_stack_name = "64bit Amazon Linux 2 v3.4.2 running Corretto 17"
  depends_on = [
    aws_elastic_beanstalk_application.transportes_mj_beanstalk
  ]

  setting {
    namespace = "aws:ec2:vpc"
    name      = "VPCId"
    value     = aws_vpc.transportes_mj_vpc.id
  }

  setting {
    namespace = "aws:ec2:vpc"
    name      = "Subnets"
    value     = aws_subnet.transportes_mj_subnet.id
  }

  setting {
    namespace = "aws:ec2:instances"
    name      = "InstanceTypes"
    value     = "t2.micro"
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "IamInstanceProfile"
    value     = "aws-elasticbeanstalk-ec2-role"
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "SecurityGroups"
    value     = aws_security_group.transportes_mj_sg.id
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "SecurityGroups"
    value     = aws_security_group.transportes_mj_db_sg.id
  }

  setting {
    namespace = "aws:elasticbeanstalk:environment"
    name      = "EnvironmentType"
    value     = "SingleInstance"
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "DATABASE_URL"
    value     = "jdbc:mysql://${aws_db_instance.transportes_mj_rds.endpoint}/${aws_db_instance.transportes_mj_rds.db_name}"
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "DATABASE_USER"
    value     = var.DATABASE_USER
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "DATABASE_PASS"
    value     = var.DATABASE_PASS
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "SPRING_PROFILES_ACTIVE"
    value     = var.ENVIRONMENT
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "PORT"
    value     = var.PORT
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "D4SIGN_BASE_URL"
    value     = var.D4SIGN_BASE_URL
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "D4SIGN_TOKEN"
    value     = var.D4SIGN_TOKEN
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "D4SIGN_CRYPTKEY"
    value     = var.D4SIGN_CRYPTKEY
  }

  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "D4SIGN_SAFE_UUID"
    value     = var.D4SIGN_SAFE_UUID
  }

}
