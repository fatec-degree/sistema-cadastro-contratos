terraform {
  cloud {
    organization = "transportes-mj"

    workspaces {
      name = "transportes-mj-workspace"
    }
  }
}
