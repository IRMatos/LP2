#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int r,g,b:
} Color;

typedef struct Figure{
    int x, y;
    void (* print) (struct Figure*);
} Figure;


typedef struct {
	    Figure super;
	    int w, h;
	} Rect;

	void rect_print (Rect* this) {
	    Figure* sup = (Figure*) this;
	    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
	           this->w, this->h, sup->x, sup->y);
	}

	Rect* rect_new (int x, int y, int w, int h) {
	    Rect*   this  = malloc(sizeof(Rect));
	    Figure* sup = (Figure*) this;
	    sup->print = (Figure_Print) rect_print;
	    sup->x = x;
	    sup->y = y;
	    this->w = w;
	    this->h = h;
	}

	///////////////////////////////////////////////////////////////////////////////

	typedef struct {
	    Figure super;
	    int w, h;
	} Ellipse;

	void Ellipse_print (Ellipse* this) {
	    Figure* sup = (Figure*) this;
	    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
	           this->w, this->h, sup->x, sup->y);
	}

	Ellipse* ellipse_new (int x, int y, int w, int h) {
	    Ellipse* this = malloc(sizeof(Ellipse));
	    Figure* sup = (Figure*) this;
	    sup->print = (Figure_Print) Ellipse_print;
	    sup->x = x;
	    sup->y = y;
	    this->w = w;
	    this->h = h;
	}

	///////////////////////////////////////////////////////////////////////////////

    typedef struct {
        Figure super;
        int w,h;
    } Linha;


    void Linha_print(Linha*this){
        Figure* super = (Figure*) this;
        printf("Linha com tamanho de: (%d,%d), e posição: (%d, %d)", this->w, this->h, sup->x, sup->y);
    }

    Texto* texto_new (int x, int y, int w, int h){
        Linha* this = malloc(sizeof(Linha));
        Figure* sup = (Figure*) this;
        sup->print = (Figure_Print) Linha_print;
        sup->x = x;
        sup->y = y;
        this->w = w;
        this->h = h;
    }
    /////////////////////////////////////////////////////////////////////////////////////////

    typedef struct{
        Figure super;
        int x3, y1, y2, y3;
    } Triangle;
    
    void Triangle_print(Triangle* this){
        Figure* super = (Figure*) this;
        printf("Triangulo com os vertices: (%d, %d), (%d, %d) e (%d, %d)", sup->x, sup->y, this->x3, this->y1, this->y2,this->y3);
    }
    
    Triangle* triangle_new(int x, int y, int x3, int y1, int y2, int y3){
        Triangle* this = malloc(sizeof(Triangle));
        Figure* sup = (Figure*) this;
        sup-> print = (Figure_Print) Triangle_print;
        sup->x = x;
        sup->y = y;
        this->x3 = x3;
        this->y1 = y1;
        this->y2 = y2;
        this->y3 = y3;
        
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    
    int main(){
        Figure* figs[4] = {
            (Figure*) rect_new(100,120,150,190,220);
            (Figure*) ellipse_new(25,10,50,300);
            (Figure*) linha_new(100,205,140,30);
            (Figure*) triangle_new(30,40,20,100,120,140);
        };
        
        for(int i=0; i<4; i++){
            figs[i]->print(figs[i]);
        }
        
        for(int i=0; i<4; i++){
            free(figs[i]);
        }
        
        
    }
