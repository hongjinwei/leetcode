/*
Merge k Sorted Lists Total 
Merge k sorted linked lists and return it as one sorted list. 
Analyze and describe its complexity.

@https://leetcode.com/problems/merge-k-sorted-lists/
*/
#include<stdio.h>
#include<stdlib.h>

#define LNode struct ListNode

struct ListNode {
    int val;
    struct ListNode *next;
};


typedef struct BTNode{
	int val;
	struct BTNode *lchild, *rchild;
}BTNode;

BTNode *tree = NULL;
LNode *s = NULL;
LNode *lhead = NULL;


BTNode *createBTNode(int val)
{
	BTNode *p = (BTNode *)malloc(sizeof(BTNode));
	p->rchild = p->lchild = NULL;
	p->val = val;
	return p;
}

LNode *createLNode(int val)
{
	LNode *p;
	p = (LNode *)malloc(sizeof(LNode));
	p->val = val;
	p->next = NULL;
	return p;
}

void addTree(int val)
{
	if(tree == NULL){
		tree =  createBTNode(val);
		return ;
	}
	BTNode *p = tree;
	while(1){
	
		if(val < p->val){
			if(p->lchild != NULL){		
				p = p->lchild;
			}else{
				p->lchild = createBTNode(val);
				return ;
			}
		}else{
			if(p->rchild != NULL){
				p = p->rchild;
			}else{
				p->rchild = createBTNode(val);
				return ;
			}
		}
	}
}

void createList(BTNode *p)
{
	if(p != NULL){

		createList(p->lchild);
		if(s == NULL){		
			s = createLNode(p->val);
			lhead = s;
			//printf("tree node: %d\n",p->val);
		}else{					
			LNode *q;
			q = createLNode(p->val);
			s->next = q;
			//printf(" %d %d\n",l->val, l->next->val);
			s = s->next;
		}
		createList(p->rchild);
	}
}

struct ListNode* mergeKLists(struct ListNode** lists, int listsSize) {
	LNode *l = NULL;

	int i = 0;
	for(; i < listsSize; i++){
		if(lists[i] != NULL && lists[i]->next != NULL){
			l = lists[i] -> next;
			while(l != NULL){
				addTree(l->val);
				l = l -> next;
			}	
		}
	}
	
	createList(tree);
	return lhead;
}

void printList(LNode *p)
{
	if(p==NULL){
		printf("NULL\n");
		return;
	}
	while(p!=NULL){
		printf("%d ",p->val);
		p = p->next;
	}
	printf("\n");
}

LNode *create(int a[], int size)
{
	LNode *l,*p,*head;
	if(size == 0) return NULL;
	l = createLNode(a[0]);
	head = l;
	int i = 1;
	for(;i<size;i++){
		p = createLNode(a[i]);
		l->next = p;
		l = l-> next;	
	}
	return head;
}

LNode **createTestCase()
{
	//int a[4] = {2,4,5,7};
	int b[1] = {};
	LNode *p;
	LNode **l;
	l = (LNode **)malloc(sizeof(LNode *) * 2);
	
	//l[0] = NULL;
	//l[1] = NULL;
	l[1] = create(b,0);
	l[2] = create(b,0);

	return l;
}


int main()
{
	LNode **l;
	l = NULL;
	l = createTestCase();

	int i = 0;
	for( ; i<2; i++){
		printf("test list %d: " ,i);
		printList(l[i]);
	}
	
	LNode *p = NULL;
	p = mergeKLists(l,2);
	printf("result: ");
	printList(p);
	printf("pass!\n");
}

