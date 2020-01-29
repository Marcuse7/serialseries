


import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Program {
    @Id
    private String id;
    private String programName;
    private String station;
    private Date airTimeStart;
    private Date airTimeEnd;

    public Program() {
        }



        public Program(String id, String programName, String station, Date airTimeStart, Date airTimeEnd) {
		super();
		this.id = id;
		this.programName = programName;
		this.station = station;
		this.airTimeStart = airTimeStart;
		this.airTimeEnd = airTimeEnd;
	}



		public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProgramName() {
            return programName;
        }


        public void setProgramName(String programName) {
            this.programName = programName;
        }

        public String getStation() {
            return station;
        }

        public void setStation(String station) {
            this.station = station;
        }


        public Date getAirTimeStart () {
            return airTimeStart;
        }

        public void setAirTimeStart (Date airTimeStart) {
            this.airTimeStart = airTimeStart;
        }

        public Date getAirTimeEnd () {
            return airTimeEnd;
        }

        public void setAirTimeEnd (Date airTimeEnd) {
           this.airTimeEnd = airTimeEnd;
        }

}
