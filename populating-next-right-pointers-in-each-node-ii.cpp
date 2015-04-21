
#include<stdio.h>
#include<stdlib.h>
#define Node struct TreeLinkNode
#define MAX 20
///*
struct TreeLinkNode {
	int val;
	struct TreeLinkNode *left, *right, *next;
};
//*/

typedef struct queue{
	int level;
	Node *node;
}queue;

int front = 0;
int rear = 0;
queue q[MAX];

void push(Node *p, int level)
{
	p->next = NULL;
	q[rear].node = p;
	q[rear].level = level;
	rear++; 
}

queue pop()
{
	return q[front++]; 
}

int isEmpty()
{
	return (front==rear);
}

void connect(Node *root) {
    
    root->next = NULL;
	queue tmp;
	if(root == NULL){
		return ;
	}else{
		push(root,1);
	}
	while(!isEmpty()){
		tmp = pop();
		if(tmp.node->left != NULL){
			push(tmp.node->left,tmp.level+1);
		}
		
		if(tmp.node->right != NULL){
			push(tmp.node->right,tmp.level+1);
		}
	}
	
	front = 0;
	while(front + 1 < rear){
		while(front+1 < rear && q[front+1].level == q[front].level){
			q[front].node->next = q[front].node;
			front++;
		}
		if(front+1 < rear){
			q[front].node->next = NULL;
		}
	}
}

int main()
{
	printf("yes!");
}

