//Intersection Point in Y Shaped Linked Lists

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
         // code here
         int size1 = 0;
         Node temp = head1;
         while(temp!=null){
             size1++;
             temp=temp.next;
         }
         
         int size2 = 0;
         temp = head2;
         while(temp!=null){
             size2++;
             temp=temp.next;
         }
         
         int delta = Math.abs(size1-size2);
         Node t1=head1;
         Node t2=head2;
         if(size1>size2){
             for(int i=0; i<delta; i++){
                 t1=t1.next;
             }
         }else if(size2>size1){
             for(int i=0; i<delta; i++){
                 t2=t2.next;
             }
         }
         
         while(t1!=t2){
             t1=t1.next;
             t2=t2.next;
             if(t1==null || t2==null){
                 return -1;
             }
         }
         
         return t1.data;
	}
}
