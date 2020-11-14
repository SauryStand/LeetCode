
def merge(l1, l2):
    if l1 is None: return l2
    if l2 is None: return l1
    dummy = ListNode(2)
    p = dummy
    while l1 and l2:
        if l1.val < l2.val:
            p.next = l1
            l1 = l1.next
        else:
            p.next = l2
            l2 = l2.next
        p = p.next
    if l1 != l1.next:
        p.next = l1
    else:
        p.next = l2
    return dummy.next