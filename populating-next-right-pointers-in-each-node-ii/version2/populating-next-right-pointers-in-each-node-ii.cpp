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

void connect(Node *root) {
    
	if(root == NULL){
		return ;
	}else{
		root->next = NULL;
	}
	
	Node *parent = root;
	Node *head = NULL;
	Node *curr = NULL;

	while(parent != NULL){
		if(head == NULL){
			if(parent->left != NULL){
				curr = head = parent->left;
				head->next = (parent->right == NULL)?NULL:parent->right;
				curr = (parent->right == NULL)?head:parent->right;
				curr->next = NULL;
			}else if(parent->right != NULL){
				curr = head = parent->right;
				curr->next = NULL;
			}
		}else{	
			if(parent->left != NULL && curr != NULL){		
				curr->next = parent->left;
				curr = parent->left;
				if(parent->right != NULL){
					curr->next = parent->right;
					curr = parent ->right;
				}
				curr->next = NULL;
			}else if(parent->right != NULL && curr != NULL){
				curr->next = parent->right;
				curr = parent->right;
				curr->next = NULL;
			}
		}

		parent = parent ->next;
		if(parent == NULL){
			parent = head;
			head = NULL;
			curr = NULL;
		}
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
	Node *s = createNode(4);
	Node *t = createNode(5);
	p->left=q;
	p->right = r;
	q->left = s;
	q->right = t;
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
	Node *p=root->left;
	while(p!=NULL){
		printf("%d ",p->val);
		p= p->next;
	}
	
	printf("\n");
	p=root->left->left;
	while(p != NULL){
		printf("%d ",p->val);
		p = p->next;
	}
}

