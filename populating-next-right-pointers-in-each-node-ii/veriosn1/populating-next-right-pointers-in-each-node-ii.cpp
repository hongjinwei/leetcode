//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

#include<stdio.h>
#include<stdlib.h>

///*
struct TreeLinkNode {
	int val;
	struct TreeLinkNode *left, *right, *next;
};
//*/

#define Node struct TreeLinkNode
#define MAX 30

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
		if(q[front+1].level == q[front].level){
			q[front].node->next = q[front+1].node;
		}
		front++;
	}
}

Node *createNode(int val)
{
	Node *p = (Node *)malloc(sizeof(Node));
	p->left = p->right = NULL;
	p->val = val;
	return p;
}
Node *createTree()
{
	Node *p = createNode(1);
	Node *q = createNode(2);
	Node *r = createNode(3);
	p->left=q;
	p->right = r;
	return p;
}

void print()
{
	printf("yes!\n");
}

int main()
{
	Node *root = createTree();
	connect(root);
	if(root->next == NULL){
		print();
	}
	if(root->left->next==NULL){
		print();
	}
}

