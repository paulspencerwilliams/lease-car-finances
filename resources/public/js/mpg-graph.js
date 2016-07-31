$(function () {
    $('#chartContainer').highcharts({
        chart: {
            type: 'area'
        },
        title: {
            text: 'MPGs'
        },
        xAxis: {
            type: 'datetime',
            dateTimeLabelFormats: {
                month: '%e. %b',
                year: '%b'
            },
            title: {
                text: 'Date'
            }
        },
        yAxis: {
            title: {
                text: 'MPG'
            },
            min: 0
        },
        tooltip: {
            headerFormat: '<b>{series.name}</b><br>',
            pointFormat: '{point.x:%e. %b}: {point.y:.2f} m'
        },
        series: [{
            name: 'MPG',
            data: mpgs
        }]
    });
});
