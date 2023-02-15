public class GasStation {
    public static void main(String[] args) {
        String[] strings = new String[]{"4", "1:1", "2:2", "1:2", "0:1"};
        System.out.println(gasStation(strings));

    }

    public static String gasStation(String[] strArr){
        int totalGasStations = Integer.parseInt(strArr[0]);
        String[] routes = new String[totalGasStations];
        for (int i=0;i<totalGasStations;i++){
            routes[i] = strArr[i+1];
        }

        for (int i=0;i<routes.length;i++){
            int offset = i; int count = 0; int gasStorage = 0;
            while (count<routes.length){
                String[] station = routes[offset].split(":");
                gasStorage += Integer.parseInt(station[0]);
                int gasRequired = Integer.parseInt(station[1]);

                if(gasStorage<gasRequired){
                    break;
                } else {
                    gasStorage -= gasRequired;
                    offset = offset + 1 == routes.length ? 0 : offset+1;
                    count++;
                }
            }

            if(count == routes.length){
                return String.valueOf(i+1);
            }
        }
        return "impossible";
    }
}
