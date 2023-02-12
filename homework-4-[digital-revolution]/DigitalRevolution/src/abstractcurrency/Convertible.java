package abstractcurrency;

public interface Convertible {

    double convertToBTC();

    double convertToSBB();

    double convertToRTA();

    double convertToQAQ();

    double convertToUSD();

    double convertToCAD();

    double convertToJAP();

    double convertToCHF();

    double convertToGold();

    double convertToCurrency(AbstractCurrency currency);
}
