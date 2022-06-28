Feature: US1005 kullanici database'de update yapar

  Scenario: TC05 kullanici database'de update yapabilmeli

    Given kullanici DBUtils ile HMC veri tabanina baglanir
    Then tHOTEL tablosunda IDHotel degeri 1016 olan kaydin Email bilgisini "bizoldukmuacaba@gmail.com" yapar