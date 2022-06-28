package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class HMC_DBUtils_stepdefinations {

    @Given("kullanici DBUtils ile HMC veri tabanina baglanir")
    public void kullanici_db_utils_ile_hmc_veri_tabanina_baglanir() {
        DBUtils.getConnection();
    }

    @Given("kullanici DBUtils ile {string} tablosundaki {string} verilerini alir")
    public void kullanici_db_utils_ile_tablosundaki_verilerini_alir(String table, String field) {
        String query = "SELECT " + field + " FROM " + table;
        DBUtils.executeQuery(query);

    }

    @Given("kullanici DBUtils ile {string} sutunundaki verileri okur")
    public void kullanici_db_utils_ile_sutunundaki_verileri_okur(String field) throws SQLException {
        DBUtils.getResultset().first();
        System.out.println(DBUtils.getResultset().getString(field));
    }

    @And("DBUtils ile tum {string} degerlerini sira numarasi ile yazdirir")
    public void dbutilsIleTumDegerleriniSiraNumarasiIleYazdirir(String field) throws SQLException {
        DBUtils.getResultset().last();
        int sonSatirNo=DBUtils.getResultset().getRow();
        DBUtils.getResultset().first();
        for (int i = 1; i <= sonSatirNo; i++) {
            System.out.println(i+". kayit: "+DBUtils.getResultset().getString(field));
            DBUtils.getResultset().next();
        }

    }

    @Then("DBUtill ile {int}. {string} in {int} oldugunu test eder")
    public void dbutillIleInOldugunuTestEder(int istenenSiraNo, String field, int ExpectedDeger) throws SQLException {
        DBUtils.getResultset().absolute(2);
        double actualDeger=DBUtils.getResultset().getDouble(field);
        System.out.println("actualDeger = " + actualDeger);
        System.out.println("ExpectedDeger = " + ExpectedDeger);
        Assert.assertTrue(actualDeger==ExpectedDeger);
    }
}
