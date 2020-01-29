import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private int id;
	private String name;
	private String nickName;
	private String eMail;
	private String password;
	private ArrayList<String> Watchlist;      // Preferred stations
	private ArrayList<String> Wantedlist;    // Missing Episodes
	private ArrayList<Integer> StationsPositive;	  // Preferred Stations
	private ArrayList<Integer> StationsNegative;	  // Stations not available

	public ArrayList<String> getWatchlist() {
		return Watchlist;
	}

	public void setWatchlist(ArrayList<String> watchlist) {
		Watchlist = watchlist;
	}

	public ArrayList<String> getWantedlist() {
		return Wantedlist;
	}

	public void setWantedlist(ArrayList<String> wantedlist) {
		Wantedlist = wantedlist;
	}

	public ArrayList<Integer> getStationsPositive() {
		return StationsPositive;
	}

	public void setStationsPositive(ArrayList<Integer> stationsPositive) {
		StationsPositive = stationsPositive;
	}

	public ArrayList<Integer> getStationsNegative() {
		return StationsNegative;
	}

	public void setStationsNegative(ArrayList<Integer> stationsNegative) {
		StationsNegative = stationsNegative;
	}

	public User(int id, String name, String nickName, String eMail, String password) {
		super();
		this.id = id;
		this.name = name;
		this.nickName = nickName;
		this.eMail = eMail;
		this.password = password;
	}

	public User () {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	


}
