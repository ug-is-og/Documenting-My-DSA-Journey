<h2><a href="https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag">No companies found for this problem</div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>1130. Minimum Cost Tree From Leaf Values</a></h2><h3>Medium</h3><hr><div><p>Given an array <code>arr</code> of positive integers, consider all binary trees such that:</p>

<ul>
	<li>Each node has either <code>0</code> or <code>2</code> children;</li>
	<li>The values of <code>arr</code> correspond to the values of each <strong>leaf</strong> in an in-order traversal of the tree.</li>
	<li>The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.</li>
</ul>

<p>Among all possible binary trees considered, return <em>the smallest possible sum of the values of each non-leaf node</em>. It is guaranteed this sum fits into a <strong>32-bit</strong> integer.</p>

<p>A node is a <strong>leaf</strong> if and only if it has zero children.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/10/tree1.jpg" style="width: 500px; height: 169px;">
<pre><strong>Input:</strong> arr = [6,2,4]
<strong>Output:</strong> 32
<strong>Explanation:</strong> There are two possible trees shown.
The first has a non-leaf node sum 36, and the second has non-leaf node sum 32.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/10/tree2.jpg" style="width: 224px; height: 145px;">
<pre><strong>Input:</strong> arr = [4,11]
<strong>Output:</strong> 44
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= arr.length &lt;= 40</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 15</code></li>
	<li>It is guaranteed that the answer fits into a <strong>32-bit</strong> signed integer (i.e., it is less than 2<sup>31</sup>).</li>
</ul>
</div>