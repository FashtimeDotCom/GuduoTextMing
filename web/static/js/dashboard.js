/**
 * Created by xljlx on 2016/3/31.
 */
var now=new Date();
$("#sys-date").html("数据截止至："+ (1900 + now.getYear()) +"-"+ (now.getMonth()+1) +"-"+ now.getDate())
// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));
option = {
  tooltip : {
    trigger: 'axis',
    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
      type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
    }
  },
  legend: {
    data:['最好的我们','太阳的后裔','欢乐颂','太阳的后裔'],
  },
  grid: {
    left: '3%',
    right: '4%',
    bottom: '3%',
    containLabel: true
  },
  xAxis : [
    {
      type : 'category',
      data : ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
    }
  ],
  yAxis : [
    {
      type : 'value'
    }
  ],
  series : [
    {
      name:'最好的我们',
      type:'bar',
      data:[320, 332, 301, 334, 390, 330, 320, 334, 390, 330, 320]
    },
    {
      name:'太阳的后裔',
      type:'bar',
      data:[120, 132, 101, 134, 90, 230, 210, 132, 101, 134, 90]
    },
    {
      name:'欢乐颂',
      type:'bar',
      data:[220, 182, 191, 234, 290, 330, 310, 191, 234, 290, 330]
    },
    {
      name:'太阳的后裔',
      type:'bar',
      data:[150, 232, 201, 154, 190, 330, 410, 232, 201, 154, 190 ,191]
    }
  ],
  color:['#ff7370','#ffca45', '#40b7e2', '#ff5e1f']
};
myChart.setOption(option);
line_option = {
  tooltip : {
    trigger: 'axis'
  },
  grid: {
    left: '3%',
    right: '4%',
    bottom: '3%',
    containLabel: true
  },
  xAxis : [
    {
      type : 'category',
      boundaryGap : false,
      data : ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
    }
  ],
  yAxis : [
    {
      type : 'value'
    }
  ],
  series : [
    {
      name:'注册用户',
      type:'line',
      stack: '万元',
      areaStyle: {normal: {}},
      data:[120, 132, 101, 134, 90, 230, 210, 101, 134, 90, 230, 210]
    },
    {
      name:'投资用户',
      type:'line',
      stack: '万元',
      areaStyle: {normal: {}},
      data:[120, 132, 101, 134, 90, 230, 210, 101, 134, 90, 230, 210]
    }
  ],
  color:['#72d2f1','#ffcee1']
};
var line_Chart = echarts.init(document.getElementById('line'));
line_Chart.setOption(line_option);
pie1_option = {
  title: {
    text: '项目类型分布',
    left: '15px'
  },
  tooltip: {
    trigger: 'item',
    formatter: "{a} <br/>{b}: {c} ({d}%)"
  },
  legend: {
    orient: 'vertical',
    x: 'right',
    data:['最好的我们','欢乐颂','武神赵子龙','旋风十一人','太阳的后裔']
  },
  series: [
    {
      name:'项目类型分布',
      type:'pie',
      radius: ['50%', '70%'],
      avoidLabelOverlap: false,
      label: {
        normal: {
          show: false,
          position: 'center'
        },
        emphasis: {
          show: true,
          textStyle: {
            fontSize: '30',
            fontWeight: 'bold'
          }
        }
      },
      labelLine: {
        normal: {
          show: false
        }
      },
      data:[
        {value:335, name:'最好的我们'},
        {value:310, name:'欢乐颂'},
        {value:234, name:'武神赵子龙'},
        {value:135, name:'太阳的后裔'},
        {value:1548, name:'旋风十一人'}
      ]
    }
  ],color:['#4fb3a4','#ff7073','#f5b977','#b1c914','#fdfc76']
};

function createRandomItemStyle() {
  return {
    normal: {
      color: 'rgb(' + [
        Math.round(Math.random() * 160),
        Math.round(Math.random() * 160),
        Math.round(Math.random() * 160)
      ].join(',') + ')'
    }
  };
}

word_option = {
  tooltip: {
    show: true
  }
};
var word_Chart = echarts.init(document.getElementById('cloud_of_word'));
word_Chart.setOption(word_option);
$(function(){
});
function getCloud(){
  var texts = $("#text").val();
  $.post('sentiment/getinfo',{text:texts},function(data){
    word_Chart.setOption({
      series: [{
        name: '文字:个数',
        type: 'wordCloud',
        size: ['100%', '100%'],
        textRotation : [0, 45, 90, -45],
        textPadding: 0,
        data: data.data
      }]
    });
  })
}
