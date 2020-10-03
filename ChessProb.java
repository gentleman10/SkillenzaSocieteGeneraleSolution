
    import java.util.*;

    public class ChessProb {

        public static void main(String[] args) {

            int put;
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            for (int n = 0; n < t; n++) {
                int boys = sc.nextInt();
                Map<Integer, Integer> boySkill = new TreeMap<>();
                Map<Integer, Integer> girlSkill = new TreeMap<>();
                for (int i = 0; i < boys; i++) {
                    put = sc.nextInt();
                    boySkill.put(put, boySkill.get(put) != null ? boySkill.get(put) + 1 : 1);
                }
                    put=0;
                int girls = sc.nextInt();
                for (int i = 0; i < girls; i++) {
                    put = sc.nextInt();
                    girlSkill.put(put, girlSkill.get(put) != null ? girlSkill.get(put) + 1 : 1);
                }
                int value;
                int count = 0;
                for (Map.Entry map : boySkill.entrySet()) {
                    value = (Integer) map.getValue();

                    while (value > 0) {
                        if (girlSkill.getOrDefault(map.getKey(),0) > 0)
                        {
                            girlSkill.put((Integer) map.getKey(), girlSkill.
                                    get((Integer) map.getKey())-1);
                            boySkill.put((Integer) map.getKey(), (Integer) map.getValue() == 1 ? 0 : (Integer) map.getValue() - 1);
                            count++;
                            value--;
                        }
                        else if(girlSkill.getOrDefault((Integer) map.getKey() - 1,0) > 0 ){
                            girlSkill.put((Integer) map.getKey()-1, girlSkill.
                                    get((Integer) map.getKey()-1) - 1);
                            boySkill.put((Integer) map.getKey(), (Integer) map.getValue() == 1 ? 0 : (Integer) map.getValue() - 1);
                            count++;
                            value--;
                        }
                        else if(girlSkill.getOrDefault((Integer) map.getKey() + 1,0) > 0){
                            girlSkill.put((Integer) map.getKey()+1, girlSkill.
                                    get((Integer) map.getKey()+1)- 1);
                            boySkill.put((Integer) map.getKey(), (Integer) map.getValue() == 1 ? 0 : (Integer) map.getValue() - 1);
                            count++;
                            value--;
                        }
                        else{ break;}

                    }
                }
                System.out.println(count);
            }


        }
    }