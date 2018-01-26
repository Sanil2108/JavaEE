import javax.persistence.*;

/**
 * Created by root on 11/1/18.
 */
@Entity(name="AlienEntity")
@Table(name = "Alien")
public class Alien {

    @Embeddable
    public static class AlienName{
        private String fName;
        private String lName;
        private String mName;

        @Override
        public String toString() {
            return "AlienName{" +
                    "fName='" + fName + '\'' +
                    ", lName='" + lName + '\'' +
                    ", mName='" + mName + '\'' +
                    '}';
        }

        public String getfName() {
            return fName;
        }

        public void setfName(String fName) {
            this.fName = fName;
        }

        public String getlName() {
            return lName;
        }

        public void setlName(String lName) {
            this.lName = lName;
        }

        public String getmName() {
            return mName;
        }

        public void setmName(String mName) {
            this.mName = mName;
        }
    }

    @Id
    private int alienId;
    private AlienName aName;
//    @Column(name = "alienColour")
    private String colour;
    @Transient
    private String columnThatIsNotStored;

    public String getColumnThatIsNotStored() {
        return columnThatIsNotStored;
    }

    public void setColumnThatIsNotStored(String columnThatIsNotStored) {
        this.columnThatIsNotStored = columnThatIsNotStored;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "alienId=" + alienId +
                ", aName='" + aName + '\'' +
                ", colour='" + colour + '\'' +
                ", columnThatIsNotStored='" + columnThatIsNotStored + '\'' +
                '}';
    }

    public int getAlienId() {
        return alienId;
    }

    public void setAlienId(int alienId) {
        this.alienId = alienId;
    }

    public AlienName getaName() {
        return aName;
    }

    public void setaName(AlienName aName) {
        this.aName = aName;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
