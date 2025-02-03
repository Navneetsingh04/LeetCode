class MyCalendarTwo {
    List<int[]> doubleOverlappeRegion ;
    List<int[]> overallBooking;
    public MyCalendarTwo() {
        doubleOverlappeRegion = new ArrayList<>();
        overallBooking = new ArrayList<>();
    }
    public boolean checkOverLap(int start1,int end1,int start2,int end2){
        return Math.max(start1,start2) < Math.min(end1,end2);
    }
    public int[] findOverLappedRegion(int start1,int end1,int start2,int end2){
        return new int[]{Math.max(start1,start2),Math.min(end1,end2)};
    }
    public boolean book(int start, int end) {
        // Check if a triple booking is being created or not
        for(int region[] : doubleOverlappeRegion){
            if(checkOverLap(region[0],region[1],start,end)){
                return false;
            }
        }
        // Check if it is creating double bookings
        for(int booking[] : overallBooking){
            if(checkOverLap(booking[0],booking[1],start,end)){
                doubleOverlappeRegion.add(findOverLappedRegion(booking[0],booking[1],start,end));
            }
        }
        // Add the current booking to the overall bookings list
        overallBooking.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */