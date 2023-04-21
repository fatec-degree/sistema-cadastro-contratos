variable "DATABASE_USER" {
  type      = string
  sensitive = true
}

variable "DATABASE_PASS" {
  type      = string
  sensitive = true
}

variable "ENVIRONMENT" {
  type    = string
  default = "dev"
}

variable "PORT" {
  type    = string
  default = 5000
}

variable "D4SIGN_TOKEN" {
  type      = string
  sensitive = true
}

variable "D4SIGN_CRYPTKEY" {
  type      = string
  sensitive = true
}

variable "D4SIGN_BASE_URL" {
  type      = string
  sensitive = true
}

variable "D4SIGN_SAFE_UUID" {
  type      = string
  sensitive = true
}
