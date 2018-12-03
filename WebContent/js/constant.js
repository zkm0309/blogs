/*常量*/
var CONSTANT = {
        DATA_TABLES : {
            DEFAULT_OPTION : { //DataTables初始化选项
            	bStateSave: false,
        		bSort:false,
        		bPaginate:true,
        		sPaginationType: "full_numbers",
        		bFilter:false,
        		bLengthChange:false,
        		oLanguage: {
        			sLengthMenu: "每页显示 _MENU_ 条记录",
        			sZeroRecords: "抱歉， 没有找到",
        			sInfo: "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
        			sInfoEmpty: "没有数据",
        			sInfoFiltered: "(从 _MAX_ 条数据中检索)",
        			oPaginate: {
        				sFirst: "首页",
        				sPrevious: "上一页",
        				sNext: "下一页",
        				sLast: "尾页"
        			}
        		},
                autoWidth: false,   //禁用自动调整列宽
                order: [],          //取消默认排序查询,否则复选框一列会出现小箭头
                processing: false,  //隐藏加载提示,自行处理
                serverSide: true,   //启用服务器端分页
                searching: false    //禁用原生搜索
            },
            COLUMN: {
                CHECKBOX: { //复选框单元格
                    className: "td-checkbox",
                    orderable: false,
                    width: "30px",
                    data: "id",
                    render: function (data, type, row, meta) {
                        return '<input type="checkbox" class="iCheck">';
                    }
                }
            },
            RENDER: {   //常用render可以抽取出来，如日期时间、头像等
                ELLIPSIS: function (data, type, row, meta) {
                    data = data||"";
                    return '<span title="' + data + '">' + data + '</span>';
                }
            }
        }
};



