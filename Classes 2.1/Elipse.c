#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct
{
    int x, y;
	  float foco1, foco2;

} Elipse;

void print (Elipse* e){
		printf("Elipse de focos (%f,%f) e posicao (%d, %d)\n",e->foco1, e->foco2, e->x, e->y);	
	}

int main (){
	Elipse e1 = {50.0,50.0,100,100};
	print(&e1);
	return 0;
}
