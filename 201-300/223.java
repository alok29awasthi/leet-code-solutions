/* Rectangle Area */

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        long area1 = (ax2 - ax1) * (ay2 - ay1);
        long area2 = (bx2 - bx1) * (by2 - by1);

        int cx1 = Math.max(ax1, bx1);
        int cx2 = Math.min(ax2, bx2);
        int cy1 = Math.max(ay1, by1);
        int cy2 = Math.min(ay2, by2);
        long area3 = 0;

        if(cx1 >= cx2 || cy1 >= cy2) {
            area3 = 0;
        } else {
            area3 = (cx2 - cx1) * (cy2 - cy1);
        }

        return (int)(area1 + area2 - area3);
    }
}

/*
Consider two rectangles:

Rectangle A with bottom-left corner (ax1, ay1) and top-right corner (ax2, ay2).
Rectangle B with bottom-left corner (bx1, by1) and top-right corner (bx2, by2).
For illustration, let's assume the following values:

(ax1, ay1) = (0, 0)
(ax2, ay2) = (3, 4)
(bx1, by1) = (1, 1)
(bx2, by2) = (4, 5)
Now, let's calculate the areas:

area1: Area of Rectangle A = (ax2 - ax1) * (ay2 - ay1) = (3 - 0) * (4 - 0) = 12
area2: Area of Rectangle B = (bx2 - bx1) * (by2 - by1) = (4 - 1) * (5 - 1) = 12
Now, calculate the overlapping area:

cx1: Maximum of the x-coordinates of the bottom-left corners = max(ax1, bx1) = max(0, 1) = 1
cx2: Minimum of the x-coordinates of the top-right corners = min(ax2, bx2) = min(3, 4) = 3
cy1: Maximum of the y-coordinates of the bottom-left corners = max(ay1, by1) = max(0, 1) = 1
cy2: Minimum of the y-coordinates of the top-right corners = min(ay2, by2) = min(4, 5) = 4
Now, check if there is an overlap:

If cx1 >= cx2 or cy1 >= cy2, there is no overlap, and area3 is set to 0.
Otherwise, calculate the overlapping area: area3 = (cx2 - cx1) * (cy2 - cy1) = (3 - 1) * (4 - 1) = 6
Finally, return the total area by subtracting the overlapping area from the sum of individual areas:

area = area1 + area2 - area3 = 12 + 12 - 6 = 18
So, the total area covered by the two rectangles is 18.

The solution handles cases where rectangles do not overlap or partially overlap, and it ensures accurate computation of the total area.
*/
