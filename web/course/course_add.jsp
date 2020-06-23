<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<head>
    <link rel="stylesheet" type="text/css" href=".././css/student.css">
    <meta charset="UTF-8">
    <title>添加课程</title>
</head>

<body>
    <form action="<%=request.getContextPath()%>/CourseInsertAction" method="POST" name="frm">
        <table border="1" style="width: 400px ; margin: auto;margin-top: 200px;">
            <tr class="td1">
                <td colspan="2">课程信息录入，<span class="star">*</span>为必填项</td>
            </tr>
            <tr>
                <td style="width: 20%;">名称</td>
                <td><input type="text" required name="courseName"><span class="star">*</span>20位字符</td>
            </tr>
            <tr>
                <td style="width: 20%;">性质</td>
                <td><select name="type">
                    <option value="1">通识必修课</option>
                    <option value="2">通识选修课</option>
                    <option value="3">公共基础必修课</option>
                    <option value="4">专业必修课</option>
                    <option value="5">专业选修课</option>
                </select>
                </td>
            </tr>
            <tr>
                <td style="width: 20%;">学分</td>
                <td><input type="text" required name="credit"><span class="star">*</span>数值</td>
            </tr>
            <tr>
                <td style="width: 20%;">开设年级</td>
                <td><input type="text" name="grade" required><span class="star">*</span>4位数年份</td>
            </tr>
            <tr>
                <td style="width: 20%;">开设专业</td>
                <td>
                    <input type="radio" name="major" checked="checked" value="1">软件工程<input type="radio" name="major" value="2">空间信息<span class="star">*</span>
                </td>
            </tr>
            <tr>
                <td style="width: 20%;">备注</td>
                <td><textarea cols="25" rows="3" name="detail"></textarea>200个字符以内</td>
            </tr>
            <tr>
                <td style="width: 20%;text-align: center;" colspan="2"><button type="button" onclick="check();">提交</button></td>
            </tr>
        </table>
    </form>
    <script type="text/javascript" src=".././js/datacheck.js" defer></script>
    <script type="text/javascript" defer>
        function check() {
        	if (Trim(frm.courseName.value) != null && Trim(frm.courseName.value) != "") {
                if (Trim(frm.courseName.value).length < 5 || Trim(frm.courseName.value).length > 20) {
                    alert("课程名称长度需为5~20！");
                    frm.courseName.focus();
                    return;
                }
            } else {
                alert("课程名称不能为空！");
                frm.courseName.focus();
                return;
            }

            if (Trim(frm.credit.value) != null && Trim(frm.credit.value) != "") {
                if (!IsInt(Trim(frm.credit.value))) {
                    alert("学分需为数值！");
                    frm.credit.focus();
                    return;
                }
            } else {
                alert("学分不可为空！");
                frm.credit.focus();
                return;
            }
            if (Trim(frm.grade.value) != null && Trim(frm.grade.value) != "") {
                if (Trim(frm.grade.value).length != 4 || !IsInt(Trim(frm.grade.value))) {
                    alert("请给开设年级输入四位整数的年份！");
                    frm.grade.focus;
                    return;
                }
            } else {
                alert("年份不可为空！");
                frm.grade.focus();
                return;
            }
            frm.submit();
            alert("正在提交");
        }
    </script>
</body>