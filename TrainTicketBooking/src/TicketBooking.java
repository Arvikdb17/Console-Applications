import com.model.Repository;
import com.view.MainView;

public class TicketBooking {

	public static void main(String[] args) {
		Repository r=Repository.getInstance();
		char[][] c=r.chart;
		for(char[] ch:c) {
			for(char chc : ch) {
				System.out.print(chc+" ");
			}
			System.out.println();
		}
		MainView mv=new MainView();
		mv.onCreate();

	}
	
	
	

}
