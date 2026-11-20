public class MinesCheck {
 public static void main(String[] args) throws Exception {

 for(int size:new int[]{4,5,8,16,22})for(int trial=0;trial<20;trial++){
  String[][] mines=new String[size][size];tableros.TableroMinas builder=new tableros.TableroMinas(null,mines,size,0,0);builder.llenarMinas(mines,size);int total=0;
  for(int r=0;r<size;r++)for(int c=0;c<size;c++){
   if("[M]".equals(mines[r][c])){total++;continue;}
   int adjacent=0;for(int x=Math.max(0,r-1);x<=Math.min(size-1,r+1);x++)for(int y=Math.max(0,c-1);y<=Math.min(size-1,c+1);y++)if("[M]".equals(mines[x][y]))adjacent++;
   CheckSupport.equal(mines[r][c],"["+adjacent+"]");
  }
  CheckSupport.equal(total,size*2);
 }
 try{new tableros.TableroMinas(null,null,0,0,0).llenarMinas(new String[1][1],1);throw new AssertionError();}catch(IllegalArgumentException expected){}

 CheckSupport.done();
 }
}
