package sample;

public class dataController extends commonController {
        String[] film = {"../img/avenger.jpg", "../img/spiderman.jpg"};
        String[] sinopsis = {
                "Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.",
                "Thrilled by his experience with the Avengers, young Peter Parker returns home to live with his Aunt May. Under the watchful eye of mentor Tony Stark, Parker starts to embrace his newfound identity as Spider-Man. He also tries to return to his normal daily routine -- distracted by thoughts of proving himself to be more than just a friendly neighborhood superhero. Peter must soon put his powers to the test when the evil Vulture emerges to threaten everything that he holds dear."
        };
        String[] filmname = {"Avenger", "Spiderman"};
        int[] f_harga = {399999, 299998};
        int[] f_seat = {100,50};
        
        public void sendDataUp(int a,int b){
               System.out.println("DataController");
               System.out.println("Kode Diterima : "+a);
               System.out.println("Seat awal : "+f_seat[a]);
               System.out.println("Kursi Dikurangi : "+b);
               f_seat[a] = f_seat[a] - b;
               System.out.println("Seat akhir : "+f_seat[a]);
               System.out.println("DataControllerEnd");
        }
}
