import LineChart from "@/app/dashboard/line-chart";

export default function Dashboard() {
    return (
        // Dashboard 페이지에 필요한 컴포넌트들을 불러와서 Pagejs를 구성
        // Line Chart 컴포넌트를 불러와서 구성하였음
        <div>
            <LineChart/>
            <h1>Dashboard</h1>
        </div>
    )
};
