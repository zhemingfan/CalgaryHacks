
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

class main {
	public static void main(String[] args) {
        System.out.println("Hello");

        final String url = "https://sharestobeclosed.telegraph.co.uk/indices/financials/index/MCX";
        try {
            final Document document = Jsoup.connect(url).get();
            
            for (Element row : document.select(
                "table.tablesorter.full tr")) {
                if (row.select("td:nth-of-type(1)").text().equals("")) {
                    continue;
                }
                else {
                   final String ticker = 
                           row.select("td:nth-of-type(1)").text();
                   final String name = 
                           row.select("td:nth-of-type(2)").text();
                   final String tempPrice = 
                           row.select("td.right:nth-of-type(3)").text();
                   final String tempPrice1 = 
                           tempPrice.replace(",", "");
//                    final double price = Double.parseDouble(tempPrice1);
                   
                    System.out.println(ticker + " " + name + " " + tempPrice1);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

	}
}