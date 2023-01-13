import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;

//Extends JPanel class  
public class Main extends JPanel{
    //initialize coordinates
    public static List<Point> co_ords(){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.println("Enter String: ");
        
        //Scanner scanner = new Scanner(System.in);
        //char[] input = scanner.nextLine().toCharArray();
        List<Point> graphPoints = new ArrayList<Point>();
        graphPoints.add(new Point(0,0));
        int outof = 1,guesses = 10000, search_len = 2;
        double count = 0,trys = 200000;
        char[] input = new char[search_len];
        for(int i =0; i<search_len; i++){
            int let = (int) (Math.random() * 26);
            input[i] = alphabet[let];
        }
        long startTime = System.nanoTime();
        for(int z = 0; z<trys; z++) {
            int c = 0;
            for (int i = 0; i < guesses; i++) {
                char[] guess = new char[input.length];

                for (int x = 0; x < guess.length; x++) {
                    int let = (int) (Math.random() * 26);
                    guess[x] = alphabet[let];
                }

                if (Arrays.equals(guess, input)) {
                    c++;
                }

            }
                for (int p = 0; p < graphPoints.size(); p++) {
                    if (graphPoints.get(p).x == c) {
                        graphPoints.get(p).y++;
                        break;
                    }else if (p+1 == graphPoints.size()) {
                        graphPoints.add(new Point(c, 1));
                    }
                }

                double div =(count%(trys/100));
                if(div == 0.0){
                    System.out.println(outof + "/100");
                    if(outof == 2){
                        long endTime = System.nanoTime();
                        double est = (double)(endTime-startTime);
                        double sec = est/10000000;
                        double mins = (double)Math.round(sec/60*100)/100;
                        System.out.println("Estimated Mins = " + mins);
                    }
                    outof++;
                }
                count += 1;


        }
        System.out.println(graphPoints);
        long Final = System.nanoTime();
        double estF = (double)(Final-startTime);
        double secF = estF/1000000000;
        double minsF = (double)Math.round(secF/60*100)/100;
        System.out.println("\nTotal Time = " + minsF + "\n");
        return graphPoints;
    }



    List<Point> graphPoints = co_ords();
    int marg = 30;
    @Override
    protected void paintComponent(Graphics grf){

        super.paintComponent(grf);
        Graphics2D graph = (Graphics2D)grf;

        //Sets the value of a single preference for the rendering algorithms.
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // get width and height  
        int width = getWidth();
        int height = getHeight();

        // draw graph
        graph.draw(new Line2D.Double(marg, marg, marg, height-marg));
        graph.draw(new Line2D.Double(marg, height-marg, width-marg, height-marg));

        //find value of x and scale to plot points
        double scale = (double)(height-2*marg)/getMax();
        double scalex = (double)(width-2*(marg))/width;
        double scaley = (double)(height-(2*marg))/height;

        //set color for points
        List<Point> sort_graphPoints = new ArrayList<Point>();
        for(int i = 0; i<getMax(); i++){
            sort_graphPoints.add(new Point(i,0));

        }
        for(int i = 0; i<sort_graphPoints.size(); i++){
            for(int x = 0; x<graphPoints.size(); x++){
                if(graphPoints.get(x).x == i){
                    sort_graphPoints.set(i,new Point(sort_graphPoints.get(i).x, graphPoints.get(x).y));
                    break;
                }
            }

        }



        // set points to the graph
        for(int i=0; i<sort_graphPoints.size(); i++){
            double x2, y2;
            x2 =(double)sort_graphPoints.get(i).x/getMax();
            y2 = (double)sort_graphPoints.get(i).y/getMaxy();
            double x1 = (x2*width);
            double y1 = height-(y2*height);
            double x3 = (x1*scalex)+marg;
            double y3 = (y1*scaley)+marg;
            if(i < sort_graphPoints.size()-1) {
                double snd_x2 = (double) sort_graphPoints.get(i + 1).x / getMax();
                double snd_y2 = (double) sort_graphPoints.get(i + 1).y / getMaxy();
                double snd_x1 = (snd_x2 * width);
                double snd_y1 = height - (snd_y2 * height);
                double snd_x3 = (snd_x1 * scalex) + marg;
                double snd_y3 = (snd_y1 * scaley) + marg;
                graph.setPaint(Color.BLACK);
                graph.drawLine((int)x3, (int)y3,(int)snd_x3,(int) snd_y3);
            }
            JLabel size = new JLabel();
            size.setText(String.valueOf(sort_graphPoints.get(i).y));
            size.setBounds((int) x3-15, (int)y3-20,50,40);
            super.add(size);
            graph.setPaint(Color.RED);
            graph.fillOval((int) x3-20, (int) y3-20, 40, 40);

        }
        System.out.println(sort_graphPoints);
    }

    //create getMax() method to find maximum value  
    private double getMax(){
        double max = 0;
        for(int i=0; i<graphPoints.size(); i++){
            if(graphPoints.get(i).x>max)
                max = (graphPoints.get(i).x);

        }
        return max;
    }
    private double getMaxy(){
        double max =0;
        for(int i=0; i<graphPoints.size(); i++){
            if(graphPoints.get(i).y>max)
                max = (graphPoints.get(i).y);

        }
        return max;
    }

    //main() method start  
    public static void main(String args[]){
        //create an instance of JFrame class  
        JFrame frame = new JFrame();
        // set size, layout and location for frame.  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Main());
        frame.setSize(1920, 1080);
        frame.setVisible(true);


    }
}  