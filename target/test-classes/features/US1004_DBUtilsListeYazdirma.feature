Feature: US1004 Kullanici istenen tablodaki istenen field'i listeleyebilir

  Scenario: TC04 Kullanici istenen degeri test edebilmeli

    Given kullanici DBUtils ile HMC veri tabanina baglanir
    And kullanici DBUtils ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici DBUtils ile "Price" sutunundaki verileri okur
    And DBUtils ile tum "Price" degerlerini sira numarasi ile yazdirir
