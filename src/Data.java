
public class Data implements Comparable<Data> {
    
    private String examName,examDate;
    private long dayDiff;
    
    public Data(String examName , String examDate ) {
        this.examName = examName;
        this.examDate = examDate;
    }
    
    public Data(String examName , String examDate,long dayyDiff ) {
        this.examName = examName;
        this.examDate = examDate;
        this.dayDiff = dayyDiff;
    }
    
    public String getExamName() {
        return examName;
    }

    public String getExamDate() {
        return examDate;
    }
    
    public long getDayDiff() {
        return dayDiff;
    }    

    @Override
    public int compareTo(Data dayDiff) {
        if(this.dayDiff < dayDiff.dayDiff)
            return -1;
        else if(this.dayDiff > dayDiff.dayDiff)
            return 1;
        
        return 0;
    }

    
    
}
