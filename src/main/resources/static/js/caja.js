const $d = document;

$d.addEventListener("DOMContentLoaded", () => {
  initializeTable();
});

const initializeTable = () => {
  $("#tablaCaja").DataTable({
    language: {
      url: "/language/datatables-es-mx.json",
    },
    responsive: true,
    fixedHeader: true,
    rowId: "0",
    columns: [null, null],
  });
};
