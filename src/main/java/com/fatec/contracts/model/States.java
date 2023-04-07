package com.fatec.contracts.model;

public enum States {
    ACRE("Acre"),
    ALAGOAS("Alagoas"),
    AMAPA("Amapa"),
    AMAZONAS("Amazonas"),
    BAHIA("Bahia"),
    CEARA("Ceara"),
    DISTRITO_FEDERAL("Distrito Federal"),
    ESPIRITO_SANTO("Espirito Santo"),
    GOIAS("Goias"),
    MARANHAO("Maranhao"),
    MATO_GROSSO("Mato Grosso"),
    MATO_GROSSO_DO_SUL("Mato Grosso do Sul"),
    MINAS_GERAIS("Minas Gerais"),
    PARA("Para"),
    PARAIBA("Paraiba"),
    PARANA("Parana"),
    PERNAMBUCO("Pernambuco"),
    PIAUI("Piaui"),
    RIO_DE_JANEIRO("Rio de Janeiro"),
    RIO_GRANDE_DO_NORTE("Rio Grande do Norte"),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul"),
    RONDONIA("Rondonia"),
    RORAIMA("Roraima"),
    SANTA_CATARINA("Santa Catarina"),
    SAO_PAULO("Sao Paulo"),
    SERGIPE("Sergipe"),
    TOCANTINS("Tocantins");

    private String value;

    States(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
