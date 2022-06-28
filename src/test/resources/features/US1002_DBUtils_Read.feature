Feature: US1002 kullanici DB Utils ile database'e baglanabilmeli
@DBUtils
  Scenario: TC01 Kullanici database'deki bilgileri  okur

    Given kullanici DBUtils ile HMC veri tabanina baglanir
    And kullanici DBUtils ile "tHOTELROOM" tablosundaki "Price" verilerini alir
   # select Price from tHOTELROOM
    And kullanici DBUtils ile "Price" sutunundaki verileri okur
